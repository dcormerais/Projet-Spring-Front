// src/components/Navbar.js
import React from 'react';
import { Link } from 'react-router-dom';

const Navbar = () => {
  return (
    <nav>
      <ul>
        <li><Link to="/">Home</Link></li>
        <li><Link to="/acteurs">Acteurs</Link></li>
        <li><Link to="/modify-acteurs">Modifier Acteur</Link></li> {/* Add this line */}
      </ul>
    </nav>
  );
};

export default Navbar;