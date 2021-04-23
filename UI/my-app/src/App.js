import './App.css';
import Header from './components/Header';
import React, { useState } from "react";
import UserType from "./components/UserType";
import RegisterDonor from "./components/RegisterDonor"

function App() {

  const [userStage, setUserStage] = useState(0);

  const setStageHandler = (stage) => {
    setUserStage(stage);
  };

  const getAppStage = () => {
    switch(userStage){
      case 0:
        return <UserType onUserStage={setStageHandler}/>;
      case 1:
        return <RegisterDonor onUserStage={setStageHandler}/>;
      case 2:
        return <RegisterDonor onUserStage={setStageHandler}/>;
      case 3:
        return <UserType onUserStage={setStageHandler}/>;
      default:
        return <UserType onUserStage={setStageHandler}/>;
    }
  };
  return (
    <div className="App">
      <Header/>
      {getAppStage()}
    </div>
  );
}

export default App;
