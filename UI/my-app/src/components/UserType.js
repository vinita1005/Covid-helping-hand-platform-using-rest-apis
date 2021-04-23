import React from "react";
import UserCard from "./UserCard";

export default function UserType({onUserStage}){
    return (
        <div>
            <div>
                <UserCard title="I am a Donor" iconType="donor" onSelect={() => onUserStage(1)}></UserCard>
            </div>
            <div>
                <UserCard title="I am a Patient" iconType="patient" onSelect={()=> onUserStage(2)}></UserCard>
            </div>
        </div>
    );
}