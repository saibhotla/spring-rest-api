import React, { Component } from 'react';

import './App.css';
import RestaurantList from './RestaurantList';

class App extends Component {
  render() {
    return (
      <div className="App">
          <RestaurantList/>
      </div>
    );
  }
}

export default App;
