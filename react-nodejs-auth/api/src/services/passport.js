const passport = require('passport')
const JwtStrategy = require('passport-jwt').Strategy
const ExtractJwt = require('passport-jwt').ExtractJwt
const LocalStrategy = require('passport-local')

const { User } = require('../models')
const { to }  = require('../services/utils')
const CONFIG = require('../config')

// Create local strategy
const localOptions = { usernameField: 'id' }
const localLogin = new LocalStrategy(localOptions, async function(id, password, done) {
  const [err, user] = await to(User.findById(id))

  if (err) { return done(err, false) }
  if (user) {
    const [err, isValid] = await to(user.comparePassword(password))
    if (err) { return done(err, false) }
    if (isValid) { return done(null, user) }
  }

  return done(null, false)
})

// Create JWT strategy
const jwtOptions = {
  jwtFromRequest: ExtractJwt.fromAuthHeaderAsBearerToken(),
  secretOrKey: CONFIG.JWT_SECRET_KEY
}
const jwtLogin = new JwtStrategy(jwtOptions, async function(payload, done) {
  const [err, user] = await to(User.findById(payload.sub))

  if (err) { return done(err, false) }
  if (user) {
    return done(null, user)
  } else {
    return done(null, false)
  }
})


// Tell passport to use this strategy
passport.use(localLogin)
passport.use(jwtLogin)
