import React, {Component} from 'react';
import { connect } from 'react-redux';

import { restaurantUpdate } from '../actions/mainActions';
import { restaurantDelete } from '../actions/mainActions';

class RestaurantEdit extends Component {
    constructor(props) {
        super(props);
        this.state = {
            restaurant: {
                id: undefined,
                name: ''
            }
        }
    }

    static getDerivedStateFromProps(nextProps, prevState) {
        const restaurants = nextProps.restaurants;
        const url = nextProps.url;
        const idx = url.lastIndexOf('/');
        const rid = parseInt(url.slice(idx + 1), 10);

        const restaurant = restaurants.find((r) => r.id === rid);
        if(restaurant === undefined) return prevState;

        return {...prevState, restaurant};
    }

    textChange(e) {
        const restaurant = {...this.state.restaurant, [e.target.name]: e.target.value};
        super.setState({...this.state, restaurant});
    }

    save(restaurant) {
        this.props.save(restaurant);
    }

    render() {
        return <div>
            <input type="text" name="name" value={this.state.restaurant.name} onChange={(e) => this.textChange(e)}/>
            <button onClick={() => this.save(this.state.restaurant)}>Save</button>
            <button onClick={() => this.props.delete(this.state.restaurant)}>Delete</button>
        </div>
    }
}

const mapStateToProps = (state) => {
    return {
        url: state.router.pathname,
        restaurants: state.main.restaurants
    }
};

const mapDispatchToProps = (dispatch) => {
    return {
        save: (restaurant) => dispatch(restaurantUpdate(restaurant)),
        delete: (restaurant) => dispatch(restaurantDelete(restaurant))
    }
};

export default connect(mapStateToProps, mapDispatchToProps)(RestaurantEdit);