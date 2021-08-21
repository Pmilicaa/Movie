import React from 'react'
import { SearchComponent } from './SearchComponent'


export const Header = ({setChangedMovies, movies}) => {
 
    const onSearch = (value) => {
    let result = [];
    console.log(value.toLowerCase());
    result = movies.filter((data) => {
    return data.name.includes(value);
    });
    setChangedMovies(result);
    }
    return (
        <div>
            
            <h1 className="display-1">Movie app</h1>
            <SearchComponent onSearch={onSearch}/>
        </div>
    )
}
