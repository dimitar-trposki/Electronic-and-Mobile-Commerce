import InfoIcon from '@mui/icons-material/Info';
import {Button, Card, CardActions, CardContent, Typography} from "@mui/material";

import {useNavigate} from "react-router";

const CountryCard = ({country}) => {
    const navigate = useNavigate();

    return (
        <>
            <Card sx={{boxShadow: 3, borderRadius: 2, p: 1}}>
                <CardContent>
                    <Typography variant="h5">{country.name}</Typography>
                    <Typography variant="h6">{country.continent}</Typography>
                </CardContent>
                <CardActions sx={{justifyContent: "space-between"}}>
                    <Button
                        size="small"
                        color="info"
                        startIcon={<InfoIcon/>}
                        onClick={() => navigate(`/countries/${country.id}`)}
                    >
                        Info
                    </Button>
                </CardActions>
            </Card>
        </>
    );
};

export default CountryCard;