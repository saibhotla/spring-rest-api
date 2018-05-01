import React, {Component} from 'react';
import {connect} from 'react-redux';

import './App.css';
import RestaurantList from './RestaurantList';
import {getRestaurants} from "../actions/mainActions";

class App extends Component {

    componentDidMount() {
        this.props.getRestaurants();
    }

    render() {
        return (
            <div className="App">
                <RestaurantList/>
            </div>
        );
    }
}

const mapDispatchToProps = (dispatch) => {
    return {
        getRestaurants: () => dispatch(getRestaurants())
    }
};

export default connect(undefined, mapDispatchToProps)(App);
