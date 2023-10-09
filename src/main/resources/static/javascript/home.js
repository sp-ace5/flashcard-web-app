document.addEventListener('DOMContentLoaded', () => {
    const flashcardContainer = document.getElementById('flashcard-container');
    const answerButton = document.getElementById('answerButton');
    const nextButton = document.getElementById('nextButton');
    let flashcards = [];
    let currentFlashcardIndex = 0;

    function displayFlashcard(index) {
        const flashcard = flashcards[index];
        const flashcardDiv = document.createElement('div');
        flashcardDiv.className = 'flashcard';
        flashcardDiv.innerHTML = `
            <div class="content">
                <div class="front">
                    ${flashcard.question}
                </div>
                <div class="back" style="display: none;">
                    ${flashcard.answer}
                </div>
            </div>
        `;
        flashcardContainer.innerHTML = '';
        flashcardContainer.appendChild(flashcardDiv);
    }

    function revealAnswer() {
        const flashcardDiv = flashcardContainer.querySelector('.flashcard');
        if (flashcardDiv) {
            const back = flashcardDiv.querySelector('.back');
            back.style.display = 'block';
        }
    }


    function showNextFlashcard() {
        const randomIndex = Math.floor(Math.random() * flashcards.length);
        currentFlashcardIndex = randomIndex;
        currentFlashcardIndex = (currentFlashcardIndex + 1) % flashcards.length;
        displayFlashcard(randomIndex);
    }
    console.log('Fetching flashcards');
    fetch('api/all')
        .then((response) => response.json())
        .then((data) => {
            flashcards = data;
            displayFlashcard(currentFlashcardIndex);
        })
        .catch((error) => {
            console.error('Error fetching flashcards', error);
        });


    answerButton.addEventListener('click', revealAnswer);
    nextButton.addEventListener('click', showNextFlashcard);
});