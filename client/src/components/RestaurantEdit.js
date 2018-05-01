import React, {Component} from 'react';
import { connect } from 'react-redux';

import { push as navigate } from 'redux-first-routing';

class RestaurantEdit extends Component {
    constructor(props) {
        super(props);
        this.state = {
            name: ''
        }
    }

    static getDerivedStateFromProps(nextProps, prevState) {
        const restaurants = nextProps.restaurants; // [{id: 1}, {id: 2}]
        const url = nextProps.url; // /restaurants/1
        const idx = url.lastIndexOf('/');
        const rid = url.slice(idx + 1);

        const restaurant = restaurants.find((r) => r.id === parseInt(rid));
        if(restaurant === undefined) return prevState;

        return {...prevState, name: restaurant.name};
    }

    render() {
        return <div>
            <input type="text" name="restaurantName" value={this.state.name} onChange={(e) => this.textChange(e)}/>
            <button onClick={() => this.save(this.state.name)}>Save</button>
        </div>
    }
}

const mapStateToProps = (state) => {
    return {
        url: state.router.pathname,
        restaurants: state.main.restaurants
    }
};

export default connect(mapStateToProps)(RestaurantEdit);