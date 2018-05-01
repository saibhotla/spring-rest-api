import React, {Component} from 'react';
import { connect } from 'react-redux';

class RestaurantList extends Component {
    render() {
        return this.props.restaurants.map(r => <li key={r.id}>{r.name}</li>)
    }
}

const mapStateToProps = (state) => {
    return {
        restaurants: state.main.restaurants
    }
};

export default connect(mapStateToProps)(RestaurantList);