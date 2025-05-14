import {Box, CircularProgress} from "@mui/material";
import useCountries from "../../../hooks/useCountries.js";
import CountryGrid from "../../components/countries/CountriesGrid/CountryGrid.jsx";


const CountriesPage = () => {
    const {countries, loading} = useCountries();

    return (
        <>
            <Box className="books-box">
                {loading && (
                    <Box className="progress-box">
                        <CircularProgress/>
                    </Box>
                )}
                {!loading &&
                    <>
                        <CountryGrid countries={countries}/>
                    </>
                }
            </Box>
        </>
    );
};

export default CountriesPage;