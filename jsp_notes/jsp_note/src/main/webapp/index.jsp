<script>
    document.addEventListener('DOMContentLoaded', () => {
        const form = document.querySelector('form[action="NoteServlet"]');
        form.addEventListener('submit', (event) => {
            const title = document.querySelector('#title').value;
            const content = document.querySelector('#content').value;
            if (title && content) {
                const notes = JSON.parse(localStorage.getItem('notes')) || [];
                notes.push({ title, content });
                localStorage.setItem('notes', JSON.stringify(notes));
            }
        });
        const notes = JSON.parse(localStorage.getItem('notes')) || [];
        const ul = document.querySelector('ul');
        notes.forEach(note => {
            const li = document.createElement('li');
            li.innerHTML = `<strong>${note.title}</strong>: ${note.content}`;
            ul.appendChild(li);
        });
    });
</script>
        
       
