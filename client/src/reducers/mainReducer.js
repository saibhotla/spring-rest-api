const initialState = {
    restaurants: [
        {
            id: 1,
            name: `Bob's Burgers`,
            reviews: [
                {id: 1, text: `This was great`, stars: 5}
            ]
        },
        {
            id: 2,
            name: `Los Tacos`,
            reviews: []
        }
    ]
};

const reducer = (state = initialState, action) => {
    return state;
};

export default reducer;