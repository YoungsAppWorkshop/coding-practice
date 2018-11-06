const fs = require('fs')
const path = require('path')
const Sequelize = require('sequelize')
const basename = path.basename(__filename)
const CONFIG = require('../config')


const db = {}
const options = {
  host: CONFIG.DATABASE_HOST,
  dialect: CONFIG.DATABASE_DIALECT,
  port: CONFIG.DATABASE_PORT,
  operatorsAliases: false
}
const sequelize = new Sequelize(
  CONFIG.DATABASE_NAME,
  CONFIG.DATABASE_USER,
  CONFIG.DATABASE_PASSWORD,
  options
)

fs.readdirSync(__dirname).filter(file =>
  (file.indexOf('.') !== 0) && (file !== basename) && (file.slice(-3) === '.js')
).forEach((file) => {
  const model = sequelize['import'](path.join(__dirname, file))
  db[model.name] = model
})

Object.keys(db).forEach(modelName => {
  if (db[modelName].associate) {
    db[modelName].associate(db)
  }
})

db.sequelize = sequelize
db.Sequelize = Sequelize

module.exports = db
