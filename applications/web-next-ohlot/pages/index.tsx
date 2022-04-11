import Title from "../components/Title";
import WordBox from "../components/WordBox";
import DndLayout from "../components/DndLayout";

export default function Home() {
    return (
        <div>
            <Title title={"Home"}/>
            <DndLayout>
                <WordBox message={"안녕!"}/>
                <WordBox message={"반가워요!"}/>
                <WordBox message={"좋은 날이에요!"}/>
                <WordBox message={"기분은 어때요?"}/>
                <WordBox message={"좋은 생각만 해요"}/>
            </DndLayout>
        </div>
    )
}