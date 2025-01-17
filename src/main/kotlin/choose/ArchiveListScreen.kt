package choose

import Screen.ARCHIVE_LIST_SCREEN
import openScreen

/**
 * Класс для описания экрана со списком архивов
 */
class ArchiveListScreen {
    /**
     * Выводит текст с описанием функционала экрана выбора архива и список доступных опций на экране.
     * Затем считывает пользовательский ввод
     */
    fun getArchiveList() {
        println(
            """
               Вы находитесь на экране выбора архива.
               Введите '0' если хотите создать новый архив.
               Если Вы хотите выбрать уже существующий архив, то введите его номер.
               Если Вы хотите выйти из приложения, то введите номер, соответствующий пункту 'Выход'.
            """.trimIndent()
        )
        openScreen(ARCHIVE_LIST_SCREEN)
    }
}
