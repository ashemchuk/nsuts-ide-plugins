package ru.ashemchuk.nsutsintellij

import com.intellij.openapi.diagnostic.Logger
import com.intellij.openapi.ui.DialogWrapper
import com.intellij.ui.components.JBLabel
import com.intellij.ui.components.JBPasswordField
import com.intellij.ui.components.JBTextField
import com.intellij.util.ui.FormBuilder
import java.awt.Dimension
import javax.swing.JComponent

class AuthDialog : DialogWrapper(null) {
    private val logger = Logger.getInstance(AuthDialog::class.java)

    private val loginField = JBTextField()
    private val passwordField = JBPasswordField()

    init {
        title = "Authentication"
        init()
    }

    override fun createCenterPanel(): JComponent {
        return FormBuilder.createFormBuilder()
            .addLabeledComponent(JBLabel("Login:"), loginField)
            .addLabeledComponent(JBLabel("Password:"), passwordField)
            .panel
    }

    override fun doOKAction() {
        val login = loginField.text
        val password = String(passwordField.password)

        // Логируем полученные данные
        logger.info("Auth dialog submitted - Login: $login, Password: $password")

        // Здесь можно добавить свою логику обработки
        handleAuth(login, password)

        super.doOKAction()
    }

    private fun handleAuth(login: String, password: String) {
        // TODO: Implement your authentication logic here
        logger.info("Processing authentication for user: $login")
    }

    override fun getPreferredFocusedComponent(): JComponent? {
        return loginField
    }
}