package create

import choose.Note
import archiveList
import scanner

/**
 * Класс для описания экрана создания заметки
 */
class CreateNoteScreen : CreateScreen() {

    /**
     * Создает новую заметку. Заметка добавляется в начало списка, т.е. более новые заметки отображаются первыми.
     * После создания заметки предлагает сразу ввести текст заметки.
     * После ввода текста возвращает на экран со списком заметок.
     */
    override fun create(index: Int) {
        val archive = archiveList[index - 1]
        println("Вы находитесь на экране создания заметки в архиве ${archive.first}.\nВведите, пожалуйста, имя заметки.")
        val noteName = scanner.nextLine()
        println("Отлично! Теперь введите текст заметки.")
        val noteText = scanner.nextLine()
        archive.second.add(0, Note(noteName, noteText))
        println("Заметка '$noteName' создана.")
    }
}
