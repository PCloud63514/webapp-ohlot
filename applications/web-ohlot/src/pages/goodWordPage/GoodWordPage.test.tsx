import {fireEvent, render, screen} from '@testing-library/react'
import userEvent from "@testing-library/user-event";
import GoodWordPage from "./GoodWordPage";

/**
 * 공식 사이트 https://testing-library.com/docs/react-testing-library/intro/
 */

describe('GoodWordPage Loading Test', () => {
    test('show loading(testing-library & jest)', () => {
        render(<GoodWordPage/>)

        const target = screen.getByText('loading...')

        expect(target).toBeInTheDocument() // jest의 기능을 함께 사용할 수 있다.
    })

    it('show loading(testing-library)', () => {
        const {getByText} = render(<GoodWordPage/>)
        getByText('loading...')
    })

    it('not visible loading text', () => {
       render(<GoodWordPage/>)
    })
})