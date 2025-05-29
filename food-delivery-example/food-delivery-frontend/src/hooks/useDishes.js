import {useCallback, useEffect, useState} from "react";
import dishRepository from "../repository/dishRepository.js";

const initialState = {
    dishes: [],
    loading: true,
};

const useDishes = () => {
    const [state, setState] = useState(initialState);

    // TODO: Implement this.
    const fetchDishes = () => {};

    // TODO: Implement this.
    const onAdd = () => {};

    // TODO: Implement this.
    const onEdit = () => {};

    // TODO: Implement this.
    const onDelete = () => {};

    useEffect(() => {
        // TODO: Implement this.
    }, []);

    return {...state, onAdd, onEdit, onDelete};
};

export default useDishes;