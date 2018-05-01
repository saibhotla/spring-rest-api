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
    }
};