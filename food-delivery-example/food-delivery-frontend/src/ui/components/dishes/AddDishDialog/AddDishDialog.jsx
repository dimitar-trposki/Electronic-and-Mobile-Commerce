import React from 'react';
import {
    Button,
    Dialog,
    DialogActions,
    DialogContent,
    DialogTitle,
    FormControl,
    InputLabel, MenuItem, Select,
    TextField
} from "@mui/material";
import useRestaurants from "../../../../hooks/useRestaurants.js";

const AddDishDialog = ({open, onClose, onAdd}) => {
    const restaurants = useRestaurants();

    // TODO: Implement this.

    return (
        <Dialog open={open} onClose={onClose}>
            <DialogTitle>Add Product</DialogTitle>
            <DialogContent>
                <TextField
                    margin="dense"
                    label="Name"
                    name="name"
                    fullWidth
                />
                <TextField
                    margin="dense"
                    label="Description"
                    name="description"
                    fullWidth
                    multiline
                    rows={3}
                />
                <TextField
                    margin="dense"
                    label="Price"
                    name="price"
                    type="number"
                    fullWidth
                />
                <TextField
                    margin="dense"
                    label="Quantity"
                    name="quantity"
                    type="number"
                    fullWidth
                />
                <FormControl fullWidth margin="dense">
                    <InputLabel>Restaurant</InputLabel>
                    <Select
                        name="restaurantId"
                        label="Restaurant"
                        variant="outlined"
                        className="restaurant-select"
                        MenuProps={{PaperProps: {style: {maxHeight: 100}}}}>
                        {restaurants.map((restaurant) => (
                            <MenuItem
                                key={restaurant.id}
                                value={restaurant.id}
                                className="restaurant-option"
                            >
                                {restaurant.name}
                            </MenuItem>
                        ))}
                    </Select>
                </FormControl>
            </DialogContent>
            <DialogActions>
                <Button onClick={onClose}>Cancel</Button>
                <Button variant="contained" color="primary" className="submit-btn">Add</Button>
            </DialogActions>
        </Dialog>
    );
};

export default AddDishDialog;