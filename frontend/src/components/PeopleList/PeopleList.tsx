import React from "react";
import {PersonEty} from "../../interface/PersonEty";
import { Person } from "../Person/Person";
import {dynamicSort} from "../../utils/dynamicSort";

interface Props {
    people: Array<PersonEty>;
}

export const PeopleList: React.FC<Props> = ({people}) => {
    return (
        <>
            <ol>
                {
                    people.sort(dynamicSort<PersonEty>("firstName")).map((person) => (
                        <li key={person.id}>
                            <Person person={person}/>
                        </li>
                    ))
                }
            </ol>
        </>
    )
}