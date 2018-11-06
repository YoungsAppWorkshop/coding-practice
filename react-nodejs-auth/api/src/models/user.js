const bcrypt = require('bcrypt')
const bcryptPromise = require('bcrypt-promise')
const jwt = require('jsonwebtoken')
const { TE, to } = require('../services/utils')
const CONFIG = require('../config')


module.exports = (sequelize, DataTypes) => {
  let Model = sequelize.define('User', {
    id: { type: DataTypes.STRING, primaryKey: true },
    password: DataTypes.STRING
  })

  Model.beforeSave(async (user, options) => {
    let err, salt, hash
    if (user.changed('password')) {
      [err, salt] = await to(bcrypt.genSalt(10))
      if(err) { TE(err.message, true) }

      [err, hash] = await to(bcrypt.hash(user.password, salt))
      if(err) { TE(err.message, true) }

      user.password = hash
    }
  })

  Model.prototype.comparePassword = async function (pw) {
    if (!this.password) { TE('password not set') }

    const [err, isValid] = await to(bcryptPromise.compare(pw, this.password))
    if (err) { TE(err) }

    return isValid
  }

  Model.prototype.getJWT = function () {
    const issuedAt = new Date().getTime()
    const expirationTime = parseInt(CONFIG.JWT_EXPIRATION)
    return "Bearer " + jwt.sign({ sub: this.id }, CONFIG.JWT_SECRET_KEY, {expiresIn: expirationTime})
  }

  Model.prototype.getId = function () {
    return this.dataValues.id
  }

  return Model
}
