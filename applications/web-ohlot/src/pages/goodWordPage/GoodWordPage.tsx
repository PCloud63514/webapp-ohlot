import React, {useEffect, useState} from 'react'
import axios, {AxiosResponse} from 'axios';

type IGetGoodWordFunction = () => Promise<IGoodWord[]>



interface IGoodWord {
    id: string,
    content: string,
    createAt: string | Date
    updateAt: string | Date
}

interface GoodWordPageProps {
    getGoodWordFunction?: IGetGoodWordFunction
}

async function GetGoodWordFunction():Promise<IGoodWord[]> {
    const response = await axios.get<IGoodWord[]>("http://localhost:8080/good-words")
    return response.data
}

const GoodWordPage = ({getGoodWordFunction=GetGoodWordFunction}:GoodWordPageProps) => {
    const [content, setContent] = useState<IGoodWord[]>([])

    useEffect(()=> {
        getGoodWordFunction().then(value => {
            setContent(value)
        })
    })

    return (
            <div>
                {content.map(value => <div key={value.id}>{value.content}</div>)}
            </div>
        )
}
export default GoodWordPage