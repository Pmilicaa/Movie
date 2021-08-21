import { useState, useEffect } from 'react';
import { BrowserRouter as Router, Route } from "react-router-dom";
import { Header } from './components/Header';
import { Movie } from './components/Movie';
import { Movies } from './components/Movies';
import "antd/dist/antd.css";
function App() {

  const[movies,setMovies]=useState([]);
  const[changedMovies,setChangedMovies]=useState([]);
  useEffect(()=>{
    const getMovies = async()=>{
      const getMoviesFromServer = await fetchMovies() 
      setMovies(getMoviesFromServer);
    }
    getMovies();
  },[])
  const fetchMovies = async()=>{
    const res = await fetch('http://localhost:8080/movies');
    const data = await res.json();
    return data;
  }
  return (
    <Router>
      <div className="container">
        <Header movies={movies} setChangedMovies={setChangedMovies}/>
        {changedMovies.length > 0 ? <Movies movies={changedMovies} /> : <Movies movies={movies}/>}
      </div>
    </Router>
  );
}

export default App;
