const { User }          = require('../models')
const { to, ReE, ReS }  = require('../services/utils')

const signup = async function(req, res) {
  const { id, password } = req.body

  if (!id || !password ) {
    return ReE(res, 'Please enter ID / password to register.')
  }

  const [err, user] = await to(User.create({id, password}))

  if (err) { return ReE(res, err, 422) }
  return ReS(res, {message:'Successfully created new user.', id: user.getId(), token:user.getJWT()}, 201)
}
module.exports.signup = signup


const signin = async function(req, res){
  const { user } = req

  return ReS(res, {token: user.getJWT(), id: user.getId()})
}
module.exports.signin = signin
