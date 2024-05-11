import React from "react";
import { LocationContext } from "./Context";
import { useContext } from "react";

function WelcomePage(){
    // Access the context
    const [locations, setLocations] = useContext(LocationContext);
    console.log("LOCATION : " ,locations);
    console.log(setLocations);

    // Render your component
    return(
        <div>
            <h1>Welcome to Hotel Booking App</h1>
            <p>Number of locations: {locations.length}</p>
        </div>
    )
}

export default WelcomePage;
