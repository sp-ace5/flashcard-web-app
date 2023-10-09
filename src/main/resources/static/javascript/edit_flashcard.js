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
    console.log('Load Flashcards been called');
    const flashcardDropdown = document.getElementById('flashcard-dropdown');

    fetch('/api/all')
        .then((response) => response.json())
        .then((flashcards) => {
            flashcards.forEach((flashcard) => {
                const option = document.createElement('option');
                option.value = flashcard.flashcard_id;
                option.textContent = `Flashcard ID: ${flashcard.flashcard_id}`;
                flashcardDropdown.appendChild(option);
            });

            flashcardDropdown.addEventListener('change', () => {
                const selectedFlashcardId = flashcardDropdown.value;
                const selectedFlashcard = flashcards.find(
                    (flashcard) => flashcard.flashcard_id === selectedFlashcardId
                );
            
                if (selectedFlashcard) {
                    tinymce.get("questionEditor").setContent(selectedFlashcard.question);
                    tinymce.get("answerEditor").setContent(selectedFlashcard.answer);
                } else {
                    console.error('Selected flashcard not found.');
                }
            });
        })
        .catch((error) => {
            console.error('Error fetching flashcards', error);
        });
}

loadFlashcards();

document.getElementById("delete-btn").addEventListener("click", function() {
    axios.delete("/api/flashcards/flashcard_id")
        .then(response => {
            console.log("Flashcard deleted:", response.data);
        })
        .catch(error => {
            console.error("Error deleting flashcard:", error);
        });
});