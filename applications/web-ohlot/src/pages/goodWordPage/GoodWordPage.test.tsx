import {fireEvent, render, screen} from '@testing-library/react'
// import {renderHook} from '@testing-library/react-hooks'
import userEvent from "@testing-library/user-event";
import GoodWordPage from "./GoodWordPage";
import axios from "axios";

/**
 * 공식 사이트 https://testing-library.com/docs/react-testing-library/intro/
 */

async function GetGoodWordFunction():Promise<IGoodWord[]> {
    
    return response.data
}

describe('GoodWordPage Loading Test', () => {
    test('show loading Message(testing-library & jest)', () => {
        render(<GoodWordPage />)

        const target = screen.getByText('SpyGetGoodWordFunction')

        expect(target).toBeInTheDocument() // jest의 기능을 함께 사용할 수 있다.
    })

    // it('', () => {
    //
    // })
    //
    // it('show loading(testing-library)', () => {
    //     const {getByText} = render(<GoodWordPage/>)
    //     getByText('loading...')
    // })
    //
    // it('not visible loading text', () => {
    //    render(<GoodWordPage/>)
    // })
})