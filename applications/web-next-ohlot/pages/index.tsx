import {useState} from "react";

export default function Home() {
    const [counter, setCounter] = useState(0)
    return (
        <div>
            <h1>Hello Home { counter }</h1>
            <button onClick={()=>setCounter(prevState => prevState + 1)}>Click</button>

        </div>
    )
}