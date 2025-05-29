import {useCallback, useEffect, useState} from "react";
import orderRepository from "../repository/orderRepository.js";

const useOrder = () => {
    const [order, setOrder] = useState(null);

    // TODO: Implement this.
    const fetchPendingOrder = () => {};

    // TODO: Implement this.
    const confirmPendingOrder = () => {};

    // TODO: Implement this.
    const cancelPendingOrder = () => {};

    useEffect(() => {
        // TODO: Implement this.
    }, []);

    return {order, fetchPendingOrder, confirmPendingOrder, cancelPendingOrder};
};

export default useOrder;