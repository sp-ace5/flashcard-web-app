document.getElementById("save-btn").addEventListener("click", function() {
    console.log("Post to save Flashcards has been called!");

    const questionContent = tinymce.get("questionEditor").getContent();
    const answerContent = tinymce.get("answerEditor").getContent();

    const flashcardData = {
        question: questionContent,
        answer: answerContent
    };

    axios.post("/api/save-flashcards", flashcardData)
        .then(response => {
            console.log("Flashcard saved:", response.data);
        })
        .catch(error => {
            console.error("Error saving flashcard:", error);
        });
});


function loadFlashcards() {
    console.log('Load Flashcards been called')
    fetch('/api/all')
        .then((response) => response.json())
        .then((flashcards) => {
            const questionList = document.getElementById('question-list');
            flashcards.forEach((flashcard) => {
                const listItem = document.createElement('li');
                listItem.textContent = flashcard.question;
                listItem.addEventListener('click', () => {
                    const questionInput = document.getElementById('question-input');
                    const answerInput = document.getElementById('answer-input');
                    questionInput.value = flashcard.question;
                    answerInput.value = flashcard.answer;
                });
                questionList.appendChild(listItem);
            });
        })
        .catch((error) => {
            console.error('Error fetching flashcards', error);
        });
}

loadFlashcards();

document.getElementById("delete-btn").addEventListener("click", function() {
    axios.delete("/api/flashcards/flashcardId")
        .then(response => {
            console.log("Flashcard deleted:", response.data);
        })
        .catch(error => {
            console.error("Error deleting flashcard:", error);
        });
});