const cors = require('cors')
const express = require('express')
const http = require('http')
const morgan = require('morgan')
const parseError = require('parse-error')

const api = require('./routes/api')
const models = require("./models")
const CONFIG = require('./config')



/**
 *  Create Express Instance
 */
const app = express()


models.sequelize.authenticate().then(() => {
  console.log('Connected to SQL database:', CONFIG.DATABASE_NAME)
}).catch(err => {
  console.log('Unable to connect to SQL database:', CONFIG.DATABASE_NAME, err)
})

if (CONFIG.APP === 'dev') { models.sequelize.sync() }

/**
 *  Set Express middleware
 */
app.use(morgan('combined'))
app.use(cors())
app.use('/api', api)

// 404 error
app.use((req, res, next) => {
  const payload = {
    status: 404,
    error: "Not Found",
    results: null
  }
  res.status(404).send(JSON.stringify(payload))
})

// Uncaught error handler
app.use((err, req, res, next) => {
  console.error(err)
  const payload = {
    status: err.status || 500,
    error: err.message,
    results: null
  }
  res.status(err.status || 500)
  res.send(JSON.stringify(payload))
})


/**
 *  Bind port to server
 */
const httpServer = http.Server(app)
httpServer.listen(CONFIG.HTTP_PORT, () => {
  console.log('HTTP server is listening on *:' + CONFIG.HTTP_PORT)
})

module.exports = app
