package choose

import archiveList
import scanner

/**
 * Класс для описания экрана просмотра заметки
 */
class NoteScreen {

    /**
     * Выводит на экран текст выбранной заметки. Затем считывает пользовательский ввод для выхода
     */
    fun getNote(archiveIndex: Int, noteIndex: Int) {
        val note = archiveList[archiveIndex - 1].second[noteIndex]
        println(
            """
                Вы находитесь на экране просмотра заметки '${note.name}'.
                Текст заметки:
                ${note.text}
                Чтобы вернуться на экран выбора заметки, то введите '$EXIT_NUMBER'
            """.trimIndent()
        )

        while (true) {
            when (scanner.nextLine().toIntOrNull()) {
                EXIT_NUMBER -> return
                else -> println("Введено некорректное значение! Введите, пожалуйста, число '$EXIT_NUMBER'")
            }
        }
    }

    companion object {
        private const val EXIT_NUMBER = 0
    }
}

/**
 * Класс для описания заметки
 *
 * @property [name] Имя заметки
 * @property [text] Текст заметки
 */
data class Note(val name: String, var text: String = "")
