import {useCallback, useEffect, useState} from "react";
import countryRepository from "../repository/countryRepository.js";

const initialState = {
    "countries": [],
    "loading": true,
};


const useCountries = () => {
    const [state, setState] = useState(initialState);

    const fetchCountries = useCallback(() => {
        countryRepository
            .findAll()
            .then((response) => {
                setState({
                    "countries": response.data,
                    "loading": false,
                });
            })
            .catch((error) => console.log(error));
    }, []);

    useEffect(() => {
        fetchCountries();
    }, [fetchCountries]);

    return state;
};

export default useCountries;
