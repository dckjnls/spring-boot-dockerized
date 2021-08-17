import React from 'react';
import { PersonEty } from '../../interface/PersonEty';

interface Props {
    person: PersonEty;
}

export const Person: React.FC<Props> = ({person}) => {
    return (
        <>
            <p>{person.firstName} {person.lastName}</p>
        </>
    )
}