import {useState} from "react";
import NavBar from "../components/NavBar";

export default function CounterPage() {
     const [count, setCount] = useState(0)
    return (
        <div>
            <NavBar/>
            <h1> Counter : {count}</h1>
            <button onClick={()=> {setCount(prev => prev + 1)}}>click!</button>
        </div>
    )
}