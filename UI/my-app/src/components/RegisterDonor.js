import React, { useEffect, useState } from "react";
import Card from "@material-ui/core/Card";
import CardContent from "@material-ui/core/CardContent";
import Button from "@material-ui/core/Button";
import Typography from "@material-ui/core/Typography";
import Avatar from "@material-ui/core/Avatar";
import ArrowBackIcon from "@material-ui/icons/ArrowBack";
import { DonorService } from "../service/DonorService";
import CardActions from "@material-ui/core/CardActions";
import { TextField } from "@material-ui/core";

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
  const [isValid, setIsValid] = useState(true);
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
    DonorService().RegisterDonor(donor);
    // DonorService().GreetDonor();
  };

  const onDonorChange = (event, label) => {
    let value = event.target.value;
    let updateDonor = { ...donor };
    updateDonor[label] = value;
    setDonor(updateDonor);
  };

  useEffect(() => {
    if (fullName && city && bloodType) {
      setIsValid(false);
    } else {
      setIsValid(true);
    }
  }, [fullName, city, bloodType]);

  return (
    <div>
      <Card>
        <div>
          <Avatar onClick={() => onUserStage(0)}>
            <ArrowBackIcon />
          </Avatar>
          <Typography>
            <h2>Register Donor information</h2>
          </Typography>
        </div>
        <CardContent>
          <TextField
            fullWidth
            id="standard-basic"
            label="Donor Name"
            value={fullName}
            required
            onChange={(e) => onDonorChange(e, "fullName")}
          />
          <TextField
            fullWidth
            id="standard-basic"
            label="City"
            value={city}
            required
            onChange={(e) => onDonorChange(e, "city")}
          />
          <TextField
            fullWidth
            id="standard-basic"
            label="Blood Type"
            value={bloodType}
            required
            onChange={(e) => onDonorChange(e, "bloodType")}
          />
          <TextField
            fullWidth
            id="standard-basic"
            label="State"
            value={state}
            onChange={(e) => onDonorChange(e, "state")}
          />
          <TextField
            fullWidth
            id="standard-basic"
            label="Country"
            value={country}
            onChange={(e) => onDonorChange(e, "country")}
          />
          <TextField
            fullWidth
            id="standard-basic"
            label="Contact No"
            value={contactNo}
            onChange={(e) => onDonorChange(e, "contactNo")}
          />
          <TextField
            fullWidth
            id="standard-basic"
            label="Complete Address"
            value={fullAddress}
            onChange={(e) => onDonorChange(e, "fullAddress")}
          />
        </CardContent>
        <CardActions>
          <Button
            disabled={isValid}
            onClick={onRegisterHandler}
            variant="outlined"
            size="large"
          >
            Register as Plasma Donor
          </Button>
        </CardActions>
      </Card>
    </div>
  );
}
