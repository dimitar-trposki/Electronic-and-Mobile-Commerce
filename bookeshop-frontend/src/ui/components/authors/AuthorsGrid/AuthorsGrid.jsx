import React from 'react';
import {Grid} from "@mui/material";
import AuthorCard from "../AuthorCard/AuthorCard.jsx";

const AuthorsGrid = ({authors}) => {
    return (
        <Grid container spacing={{xs: 2, md: 3}}>
            {authors.map((author) => (
                <Grid key={author.id} size={{xs: 12, sm: 6, md: 4, lg: 3}}>
                    <AuthorCard author={author}/>
                </Grid>
            ))}
        </Grid>
    );
};

export default AuthorsGrid;