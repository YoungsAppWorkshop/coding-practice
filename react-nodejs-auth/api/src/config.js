const dotenv = require('dotenv')


/**
 *  각종 환경변수(process.env) 로딩
 */
dotenv.config()

const CONFIG = {
  APP: process.env.APP || 'dev',
  HTTP_PORT: process.env.HTTP_PORT || '3000',
  DATABASE_DIALECT: process.env.DATABASE_DIALECT || 'mysql',
  DATABASE_HOST: process.env.DATABASE_HOST || 'localhost',
  DATABASE_PORT: process.env.DATABASE_PORT || '3306',
  DATABASE_NAME: process.env.DATABASE_NAME || 'name',
  DATABASE_USER: process.env.DATABASE_USER || 'root',
  DATABASE_PASSWORD: process.env.DATABASE_PASSWORD || '',
  JWT_EXPIRATION: process.env.JWT_EXPIRATION || '10000',
  JWT_SECRET_KEY: process.env.JWT_SECRET_KEY || 'jwt_please_change'
}

module.exports = CONFIG
