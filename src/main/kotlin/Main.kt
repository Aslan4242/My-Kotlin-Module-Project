import choose.ArchiveListScreen
import choose.Note
import create.CreateArchiveScreen
import create.CreateNoteScreen
import create.CreateScreen
import java.util.*

fun main(args: Array<String>) {
    println("Добро пожаловать в приложение 'Заметки'!")
    ArchiveListScreen().getArchiveList()
}

val scanner = Scanner(System.`in`)

/**
 * Список архивов. Архив представляет собой пару "Имя архива - Список заметок"
 */
/* Используется mutableListOf<Pair<String, MutableList<Note>>> вместо mutableMapOf<>()
  чтобы иметь возможность добавлять неуникальные значения */
var archiveList = mutableListOf<Pair<String, MutableList<Note>>>()

/**
 * Класс для описания экранов выбора архива/выбора заметки
 *
 * @property [screenName] Имя экрана
 * @property [actionName] Текст действия по созданию архива/заметки
 * @property [createScreen] Класс для создания архива/заметки
 */
enum class Screen(
    val screenName: String,
    val actionName: String,
    val createScreen: CreateScreen
) {
    ARCHIVE_LIST_SCREEN(
        "Список архивов",
        "Создать архив",
        CreateArchiveScreen()
    ),
    NOTE_LIST_SCREEN(
        "Список заметок архива",
        "Создать заметку",
        CreateNoteScreen()
    )
}
