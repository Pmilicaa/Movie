import React from 'react'
import {Collapse} from 'antd'
const { Panel } = Collapse;

export const Movie = ({movie}) => {

    
    return (
        <div>
            <Collapse>
                <Panel header={movie.name} key="1">
                <small>Director: {movie.director}</small><br/>
                <small>Writers: {movie.writers}</small><br/>
                <small>Genres: {movie.genre.map(function(item) {return <li key={item}>{item}</li>})}</small>
                </Panel>
            </Collapse>
                
        </div>
       
    )
}
