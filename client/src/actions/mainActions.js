import { push as navigate } from 'redux-first-routing';

export const getRestaurants = () => {
    return async (dispatch) => {
        const req = await fetch('/api/restaurants');
        const restaurants = await req.json();
        const action = gotRestaurants(restaurants);
        dispatch(action);
    }
};

export const gotRestaurants = (restaurants) => {
    return {
        type: 'GOT_RESTAURANTS',
        restaurants
    };
};

export const saveRestaurant = (restaurant) => {
    return async (dispatch) => {
        const req = await fetch('/api/restaurants', {
            method: 'post',
            headers: {
                'Accept': 'application/json, text/plain, */*',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(restaurant)
        });
        await req.json();
        dispatch(getRestaurants());
        dispatch(navigate('/restaurants'));
    }
};