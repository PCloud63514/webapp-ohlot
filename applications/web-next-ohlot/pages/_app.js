/**
 * Next JS 랜더링 순서
 * _app.js -> index.js
 */
import NavBar from "../components/NavBar";

export default function App({Component, pageProps}) {
    return (
        <div>
            <NavBar/>
            <Component {...pageProps}/>
            <style jsx global>
                {`
                    a {
                        color: white;
                    }
                `}
            </style>
        </div>
    )
}


