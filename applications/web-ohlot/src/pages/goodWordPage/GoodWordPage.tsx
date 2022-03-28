import React, {useEffect, useState} from 'react'
import axios, {AxiosResponse} from 'axios';

interface IGoodWord {
    id: string,
    content: string,
    createAt: string | Date
    updateAt: string | Date
}

interface GetGoodWords {
    () : IGoodWord[] | undefined
}

function getGoodWords() : IGoodWord[] | undefined {
    return undefined;
}

/**
 *
 * GET good-words 요청으로 목록을 가져와서
 * 박스에 내용을 담아서 화면에 보여줄 것.
 * 그렇다면 테스트의 범위는?
 *
 * 로딩 화면 정상작동 여부
 * rest api 호출 여부
 * 가져온 모든 내용을 변조 없이 박스에 담았는지 여부
 * 박스를 화면에 그려냈는지 여부
 *
 */
const GoodWordPage = ({val:GetGoodWords}: any) => {
    return (
        <div>
            loading...
        </div>
    )
}

export default GoodWordPage