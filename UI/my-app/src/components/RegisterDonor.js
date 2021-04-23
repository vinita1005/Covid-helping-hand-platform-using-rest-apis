import React, { useState } from "react";
import { makeStyles } from "@material-ui/core/styles";
import Card from "@material-ui/core/Card";
import CardContent from "@material-ui/core/CardContent";
import Button from "@material-ui/core/Button";
import Typography from "@material-ui/core/Typography";
import Avatar from "@material-ui/core/Avatar";
import ArrowBackIcon from "@material-ui/icons/ArrowBack";

import CardActions from "@material-ui/core/CardActions";
import { TextField } from "@material-ui/core";
import {DonorService} from "../service/DonorService";

   
export default function UserRegister({ onUserStage }) {
    const IntialUserData = {
        fullName: "",
        city: "",
        state: "",
        country: "",
        contactNo: "",
        fullAddress: "",
        bloodType: "",
      };
    
    const [donor, setDonor] = useState(IntialUserData);
    const {
        fullName,
        city,
        bloodType,
        state,
        country,
        contactNo,
        fullAddress,
    } = donor;

    const onRegisterHandler = () => {
        DonorService.RegisterDonor(donor);
    };

    const onDonorChange = (event, label) => {
        let value = event.target.value;
        let updateDonor = { ...donor };
        updateDonor[label] = value;
        setDonor(updateDonor);
      };

    return(
        <div>
            <Card>
                <div>
                    <Avatar onClick={()=>onUserStage(0)}>
                    <ArrowBackIcon/>
                    </Avatar>
                    <Typography><h2>Register Donor information</h2></Typography>
                </div>
                <CardContent>
                    <TextField
                    fullWidth
                    id="standard-basic"
                    label="Donor Name"
                    value={fullName}
                    onChange={(e) => onDonorChange(e, "fullName")}/>
                    <TextField
                    fullWidth
                    id="standard-basic"
                    label="City"
                    value={city}
                    onChange={(e)=> onDonorChange(e, "city")}/>
                    <TextField
                    fullWidth
                    id="standard-basic"
                    label="Blood Type"
                    value={bloodType}
                    onChange={(e)=> onDonorChange(e, "bloodType")}/>
                    <TextField
                    fullWidth
                    id="standard-basic"
                    label="State"
                    value={state}
                    onChange={(e)=> onDonorChange(e, "state")}/>
                    <TextField
                    fullWidth
                    id="standard-basic"
                    label="Country"
                    value={country}
                    onChange={(e)=> onDonorChange(e, "country")}/>
                    <TextField
                    fullWidth
                    id="standard-basic"
                    label="Contact No"
                    value={contactNo}
                    onChange={(e)=> onDonorChange(e, "contactNo")}/>
                    <TextField
                    fullWidth
                    id="standard-basic"
                    label="Complete Address"
                    value={fullAddress}
                    onChange={(e)=> onDonorChange(e, "fullAddress")}/>
                </CardContent>
                <CardActions>
                    <Button onClick={onRegisterHandler} variant="outlined" size="large">
                        Register as a Donor
                    </Button>
                </CardActions>
            </Card>
        </div>
    );
}

