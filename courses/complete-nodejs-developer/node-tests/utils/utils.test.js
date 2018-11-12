const expect = require('expect')

const utils = require('./utils')

describe('Utils', () => {

  describe('#add', () => {
    it('should add two numbers', () => {
      const res = utils.add(33, 11)
      expect(res).toBe(44).toBeA('number')
      // if (res !== 44) {
      //   throw new Error(`Expected 44, but got ${res}.`)
      // }
    })
  })


  it('should async add two numbers', (done) => {
    utils.asyncAdd(4, 3, sum => {
      expect(sum).toBe(7).toBeA('number')
      done()
    })
  })

  it('should square a number', () => {
    const res = utils.square(4)
    expect(res).toBe(16).toBeA('number')
  })

  it('should async square a number', (done) => {
    utils.asyncSquare(4, square => {
      expect(square).toBe(16).toBeA('number')
      done()
    })
  })

  it('should set first and last names', () => {
    const user = { location: 'Philadelphia', age: 25 }
    const res = utils.setName(user, 'Andrew Mead')
    expect(res).toInclude({
      firstName: 'Andrew',
      lastName: 'Mead'
    }).toBeA('object')
  })


  // it('should expect some values', () => {
  //   // expect(12).toBe(12)
  //   expect({name: 'Andrew'}).toEqual({name: 'Andrew'})
  //   expect([2, 3, 4]).toInclude(3)
  //   expect([2, 3, 4]).toExclude(1)
  //   expect({
  //     name: 'Andrew',
  //     age: 25,
  //     location: 'Philadelphia'
  //   }).toInclude({
  //     age: 25
  //   })
  // })

})
