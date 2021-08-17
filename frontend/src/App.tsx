import React, {useEffect, useState} from 'react';
import {PeopleList} from './components/PeopleList/PeopleList';
import {PersonEty} from "./interface/PersonEty";

const App: React.FC = () => {
    const [people, setPeople] = useState<Array<PersonEty>>([]);

    useEffect(() => {
        fetch(`${process.env.REACT_APP_API_URL || 'http://localhost:8080'}/api/people`)
            .then(res => res.json() as unknown as Array<PersonEty>)
            .then((data: Array<PersonEty>) => setPeople(data));
    }, []);


    return (
        <div className="App">
            <PeopleList people={people}/>
        </div>
    );
}

export default App;
