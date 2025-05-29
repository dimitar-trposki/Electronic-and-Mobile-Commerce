import axiosInstance from "../axios/axios.js";

const wishlistRepository = {
    getActiveShoppingCart: async () => {
        return await axiosInstance.getActiveShoppingCart();
    },
    addProductToWishlist: async (id) => {
        return await axiosInstance.addProductToWishlist(id);
    },
};

export default wishlistRepository;