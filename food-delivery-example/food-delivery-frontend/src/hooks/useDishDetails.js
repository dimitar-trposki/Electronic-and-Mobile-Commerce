import {useEffect, useState} from "react";

const useDishDetails = (id) => {
    const [dish, setDish] = useState(null);

    useEffect(() => {
        // TODO: Implement this.
    }, [id]);

    return dish;
};

export default useDishDetails;