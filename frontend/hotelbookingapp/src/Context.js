import React, { createContext, useContext, useEffect, useState } from "react";

// Create a context
const LocationContext = createContext();

// Create a context provider
const LocationProvider = (props) => {
    const [locations, setLocations] = useState([]);

    useEffect(() => {
        fetch("http://localhost:8080/locations")
           .then((response) => response.json())
           .then((data) => {
               setLocations(data);
               console.log("Fetched locations:", data); // Log the fetched value
           })
           .catch((error) => {
               console.error("Error fetching locations:", error);
           });
    }, []);

    return (
        <LocationContext.Provider value={[locations, setLocations]}>
            {props.children}
        </LocationContext.Provider>
    );
};

export { LocationProvider, LocationContext };
