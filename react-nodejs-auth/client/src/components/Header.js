import React from 'react'
import { Link } from 'react-router-dom'



class Header extends React.Component {
  render () {
    return (
      <div>
        <ul>
          <li><Link to="/">Redux Auth</Link></li>
          <li><Link to="/signup">Sign Up</Link></li>
          <li><Link to="/signin">Sign In</Link></li>
          <li><Link to="/signout">Sign Out</Link></li>
          <li><Link to="/feature">Feature</Link></li>
        </ul>
      </div>
    )
  }
}

export default Header
